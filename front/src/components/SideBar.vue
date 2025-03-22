<!-- <script>
export default {
    data() {
        return {
            sidebar: {
                open: false,
                displayed: false
            }
        }
    },
    mounted() {
        if (!this.$route.meta.noSidebar) {
            this.sidebar.displayed = true;
        }

        // Ouverte par défaut si taille > sm
        if (window.innerWidth > 640) {
            this.sidebar.open = true;
        } else {
            this.sidebar.open = false;
            const sidebar = document.getElementById('default-sidebar');
            sidebar.classList.remove('-translate-x-full');
        }
    },
    methods: {
        toggleSidebar() {
            const sidebar = document.getElementById('default-sidebar');
            sidebar.classList.toggle('-translate-x-full');

            this.sidebar.open = !this.sidebar.open;
        }
    }
}
</script>
<template>
   <aside v-if="sidebar.displayed" id="default-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full sm:translate-x-0" aria-label="Sidebar">
      <div class="h-full px-3 py-4 overflow-y-auto bg-gray-50">
      <ul class="space-y-2 font-medium">
         <li>
            <a href="#" class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group">
               <svg class="w-5 h-5 text-gray-500 transition duration-75  group-hover:text-gray-900 " aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 21">
                  <path d="M16.975 11H10V4.025a1 1 0 0 0-1.066-.998 8.5 8.5 0 1 0 9.039 9.039.999.999 0 0 0-1-1.066h.002Z"/>
                  <path d="M12.5 0c-.157 0-.311.01-.565.027A1 1 0 0 0 11 1.02V10h8.975a1 1 0 0 0 1-.935c.013-.188.028-.374.028-.565A8.51 8.51 0 0 0 12.5 0Z"/>
               </svg>
               <span class="ms-3">Dashboard</span>
            </a>
         </li>
         <li>
            <a href="#" class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group">
               <svg class="shrink-0 w-5 h-5 text-gray-500 transition duration-75 group-hover:text-gray-900" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 18">
                  <path d="M6.143 0H1.857A1.857 1.857 0 0 0 0 1.857v4.286C0 7.169.831 8 1.857 8h4.286A1.857 1.857 0 0 0 8 6.143V1.857A1.857 1.857 0 0 0 6.143 0Zm10 0h-4.286A1.857 1.857 0 0 0 10 1.857v4.286C10 7.169 10.831 8 11.857 8h4.286A1.857 1.857 0 0 0 18 6.143V1.857A1.857 1.857 0 0 0 16.143 0Zm-10 10H1.857A1.857 1.857 0 0 0 0 11.857v4.286C0 17.169.831 18 1.857 18h4.286A1.857 1.857 0 0 0 8 16.143v-4.286A1.857 1.857 0 0 0 6.143 10Zm10 0h-4.286A1.857 1.857 0 0 0 10 11.857v4.286c0 1.026.831 1.857 1.857 1.857h4.286A1.857 1.857 0 0 0 18 16.143v-4.286A1.857 1.857 0 0 0 16.143 10Z"/>
               </svg>
               <span class="flex-1 ms-3 whitespace-nowrap">Kanban</span>
               <span class="inline-flex items-center justify-center px-2 ms-3 text-sm font-medium text-gray-800 bg-gray-100 rounded-full">Pro</span>
            </a>
         </li>
         <li>
            <a href="#" class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group">
               <svg class="shrink-0 w-5 h-5 text-gray-500 transition duration-75 group-hover:text-gray-900" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                  <path d="m17.418 3.623-.018-.008a6.713 6.713 0 0 0-2.4-.569V2h1a1 1 0 1 0 0-2h-2a1 1 0 0 0-1 1v2H9.89A6.977 6.977 0 0 1 12 8v5h-2V8A5 5 0 1 0 0 8v6a1 1 0 0 0 1 1h8v4a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-4h6a1 1 0 0 0 1-1V8a5 5 0 0 0-2.582-4.377ZM6 12H4a1 1 0 0 1 0-2h2a1 1 0 0 1 0 2Z"/>
               </svg>
               <span class="flex-1 ms-3 whitespace-nowrap">Inbox</span>
               <span class="inline-flex items-center justify-center w-3 h-3 p-3 ms-3 text-sm font-medium text-blue-800 bg-blue-100 rounded-full">3</span>
            </a>
         </li>
         <li>
            <a href="#" class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group">
               <svg class="shrink-0 w-5 h-5 text-gray-500 transition duration-75 group-hover:text-gray-900" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 18">
                  <path d="M14 2a3.963 3.963 0 0 0-1.4.267 6.439 6.439 0 0 1-1.331 6.638A4 4 0 1 0 14 2Zm1 9h-1.264A6.957 6.957 0 0 1 15 15v2a2.97 2.97 0 0 1-.184 1H19a1 1 0 0 0 1-1v-1a5.006 5.006 0 0 0-5-5ZM6.5 9a4.5 4.5 0 1 0 0-9 4.5 4.5 0 0 0 0 9ZM8 10H5a5.006 5.006 0 0 0-5 5v2a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-2a5.006 5.006 0 0 0-5-5Z"/>
               </svg>
               <span class="flex-1 ms-3 whitespace-nowrap">Users</span>
            </a>
         </li>
      </ul>
   </div>
  </aside>
</template> -->


<template>
   <div class="card flex justify-center">
       <Drawer v-model:visible="visible">
           <template #container="{ closeCallback }">
               <div class="flex flex-col h-full">
                   <div class="flex items-center justify-between px-6 pt-4 shrink-0">
                       <span class="inline-flex items-center gap-2">
                           <svg width="35" height="40" viewBox="0 0 35 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                               <path
                                   d="M25.87 18.05L23.16 17.45L25.27 20.46V29.78L32.49 23.76V13.53L29.18 14.73L25.87 18.04V18.05ZM25.27 35.49L29.18 31.58V27.67L25.27 30.98V35.49ZM20.16 17.14H20.03H20.17H20.16ZM30.1 5.19L34.89 4.81L33.08 12.33L24.1 15.67L30.08 5.2L30.1 5.19ZM5.72 14.74L2.41 13.54V23.77L9.63 29.79V20.47L11.74 17.46L9.03 18.06L5.72 14.75V14.74ZM9.63 30.98L5.72 27.67V31.58L9.63 35.49V30.98ZM4.8 5.2L10.78 15.67L1.81 12.33L0 4.81L4.79 5.19L4.8 5.2ZM24.37 21.05V34.59L22.56 37.29L20.46 39.4H14.44L12.34 37.29L10.53 34.59V21.05L12.42 18.23L17.45 26.8L22.48 18.23L24.37 21.05ZM22.85 0L22.57 0.69L17.45 13.08L12.33 0.69L12.05 0H22.85Z"
                                   fill="var(--p-primary-color)"
                               />
                               <path
                                   d="M30.69 4.21L24.37 4.81L22.57 0.69L22.86 0H26.48L30.69 4.21ZM23.75 5.67L22.66 3.08L18.05 14.24V17.14H19.7H20.03H20.16H20.2L24.1 15.7L30.11 5.19L23.75 5.67ZM4.21002 4.21L10.53 4.81L12.33 0.69L12.05 0H8.43002L4.22002 4.21H4.21002ZM21.9 17.4L20.6 18.2H14.3L13 17.4L12.4 18.2L12.42 18.23L17.45 26.8L22.48 18.23L22.5 18.2L21.9 17.4ZM4.79002 5.19L10.8 15.7L14.7 17.14H14.74H15.2H16.85V14.24L12.24 3.09L11.15 5.68L4.79002 5.2V5.19Z"
                                   fill="var(--p-text-color)"
                               />
                           </svg>
                           <span class="font-semibold text-2xl text-primary">Your Logo</span>
                       </span>
                       <span>
                           <Button type="button" @click="closeCallback" icon="pi pi-times" rounded outlined></Button>
                       </span>
                   </div>
                   <div class="overflow-y-auto">
                       <ul class="list-none p-4 m-0">
                           <li>
                               <div
                                   v-ripple
                                   v-styleclass="{
                                       selector: '@next',
                                       enterFromClass: 'hidden',
                                       enterActiveClass: 'animate-slidedown',
                                       leaveToClass: 'hidden',
                                       leaveActiveClass: 'animate-slideup'
                                   }"
                                   class="p-4 flex items-center justify-between text-surface-500 dark:text-surface-400 cursor-pointer p-ripple"
                               >
                                   <span class="font-medium">FAVORITES</span>
                                   <i class="pi pi-chevron-down"></i>
                               </div>
                               <ul class="list-none p-0 m-0 overflow-hidden">
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-home mr-2"></i>
                                           <span class="font-medium">Dashboard</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-bookmark mr-2"></i>
                                           <span class="font-medium">Bookmarks</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a
                                           v-ripple
                                           v-styleclass="{
                                               selector: '@next',
                                               enterFromClass: 'hidden',
                                               enterActiveClass: 'animate-slidedown',
                                               leaveToClass: 'hidden',
                                               leaveActiveClass: 'animate-slideup'
                                           }"
                                           class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple"
                                       >
                                           <i class="pi pi-chart-line mr-2"></i>
                                           <span class="font-medium">Reports</span>
                                           <i class="pi pi-chevron-down ml-auto"></i>
                                       </a>
                                       <ul class="list-none py-0 pl-4 pr-0 m-0 hidden overflow-y-hidden transition-all duration-[400ms] ease-in-out">
                                           <li>
                                               <a
                                                   v-ripple
                                                   v-styleclass="{
                                                       selector: '@next',
                                                       enterFromClass: 'hidden',
                                                       enterActiveClass: 'animate-slidedown',
                                                       leaveToClass: 'hidden',
                                                       leaveActiveClass: 'animate-slideup'
                                                   }"
                                                   class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple"
                                               >
                                                   <i class="pi pi-chart-line mr-2"></i>
                                                   <span class="font-medium">Revenue</span>
                                                   <i class="pi pi-chevron-down ml-auto"></i>
                                               </a>
                                               <ul class="list-none py-0 pl-4 pr-0 m-0 hidden overflow-y-hidden transition-all duration-[400ms] ease-in-out">
                                                   <li>
                                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                                           <i class="pi pi-table mr-2"></i>
                                                           <span class="font-medium">View</span>
                                                       </a>
                                                   </li>
                                                   <li>
                                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                                           <i class="pi pi-search mr-2"></i>
                                                           <span class="font-medium">Search</span>
                                                       </a>
                                                   </li>
                                               </ul>
                                           </li>
                                           <li>
                                               <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                                   <i class="pi pi-chart-line mr-2"></i>
                                                   <span class="font-medium">Expenses</span>
                                               </a>
                                           </li>
                                       </ul>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-users mr-2"></i>
                                           <span class="font-medium">Team</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-comments mr-2"></i>
                                           <span class="font-medium">Messages</span>
                                           <span class="inline-flex items-center justify-center ml-auto bg-primary text-primary-contrast rounded-full" style="min-width: 1.5rem; height: 1.5rem">3</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-calendar mr-2"></i>
                                           <span class="font-medium">Calendar</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-cog mr-2"></i>
                                           <span class="font-medium">Settings</span>
                                       </a>
                                   </li>
                               </ul>
                           </li>
                       </ul>
                       <ul class="list-none p-4 m-0">
                           <li>
                               <div
                                   v-ripple
                                   v-styleclass="{
                                       selector: '@next',
                                       enterFromClass: 'hidden',
                                       enterActiveClass: 'animate-slidedown',
                                       leaveToClass: 'hidden',
                                       leaveActiveClass: 'animate-slideup'
                                   }"
                                   class="p-4 flex items-center justify-between text-surface-500 dark:text-surface-400 cursor-pointer p-ripple"
                               >
                                   <span class="font-medium">APPLICATION</span>
                                   <i class="pi pi-chevron-down"></i>
                               </div>
                               <ul class="list-none p-0 m-0 overflow-hidden">
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-folder mr-2"></i>
                                           <span class="font-medium">Projects</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-chart-bar mr-2"></i>
                                           <span class="font-medium">Performance</span>
                                       </a>
                                   </li>
                                   <li>
                                       <a v-ripple class="flex items-center cursor-pointer p-4 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                                           <i class="pi pi-cog mr-2"></i>
                                           <span class="font-medium">Settings</span>
                                       </a>
                                   </li>
                               </ul>
                           </li>
                       </ul>
                   </div>
                   <div class="mt-auto">
                       <hr class="mb-4 mx-4 border-t border-0 border-surface-200 dark:border-surface-700" />
                       <a v-ripple class="m-4 flex items-center cursor-pointer p-4 gap-2 rounded text-surface-700 hover:bg-surface-100 dark:text-surface-0 dark:hover:bg-surface-800 duration-150 transition-colors p-ripple">
                           <Avatar image="https://primefaces.org/cdn/primevue/images/avatar/amyelsner.png" shape="circle" />
                           <span class="font-bold">Amy Elsner</span>
                       </a>
                   </div>
               </div>
           </template>
       </Drawer>
       <Button icon="pi pi-bars" @click="visible = true" />
   </div>
</template>

<script>
import { Drawer, Button, Avatar } from 'primevue';
export default {
   components: {
       Drawer,
       Button,
       Avatar
   },
   data() {
       return {
           visible: false
       }
   },
   methods: {
      closeCallback
   }
}
</script>
