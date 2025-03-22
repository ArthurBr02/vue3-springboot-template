import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/dashboard/HomeView.vue'),
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: '/login',
      name: 'login',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/auth/LoginView.vue'),
      meta: {
        noSidebar: true,
        noNavbar: true,
      },
    },
    {
      path: '/register',
      name: 'register',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/auth/RegisterView.vue'),
      meta: {
        noSidebar: true,
        noNavbar: true,
      },
    },
    
    {
      path: '/reset-password',
      name: 'resetPassword',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/auth/ResetPasswordView.vue'),
      meta: {
        noSidebar: true,
        noNavbar: true,
      },
    },
  ],
});

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token');
  const decodedToken = token ? JSON.parse(atob(token.split('.')[1])) : null;
  const isAuthenticated = decodedToken ? decodedToken.exp * 1000 > Date.now() : false;

  if (to.matched.some(record => record.meta.requiresAuth) && !isAuthenticated) {
    localStorage.removeItem('token');
    next({ name: 'login' });
  } else {
    next();
  }
});

export default router
