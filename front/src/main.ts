import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import PrimeVue from 'primevue/config'

import 'primeicons/primeicons.css'

import Aura from '@primeuix/themes/aura'

import App from './App.vue'
import router from './router'

import { createI18n } from 'vue-i18n'

import Button from "primevue/button"
import Card from "primevue/card";
import ToastService from 'primevue/toastservice';
import { ConfirmationService } from 'primevue'

import Ripple from 'primevue/ripple';
import { StyleClass } from 'primevue'

import fr from "@/locale/fr.ts";
import en from "@/locale/en.ts";
import { jwtDecode } from 'jwt-decode'

const i18n = createI18n({
    locale: 'fr',
    messages: {
        en: en,
        fr: fr
    }
  });

const app = createApp(App)

app.use(createPinia())
app.use(i18n)
app.use(router)
app.use(PrimeVue, {
    theme: {
        preset: Aura,
        options: {
            darkModeSelector: false || 'none',
        }
    },
    ripple: true
})
app.use(ToastService);
app.use(ConfirmationService);

app.component('Button', Button)
app.component('Card', Card)

app.directive('ripple', Ripple);
app.directive('styleclass', StyleClass);

app.mount('#app')

// Si un token est présent dans le local storage, on récupère la locale et on l'applique
const token = localStorage.getItem('token')
if (token) {
    const locale = jwtDecode(token).locale;
    i18n.global.locale = locale;
}