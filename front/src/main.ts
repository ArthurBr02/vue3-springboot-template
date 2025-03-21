import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import PrimeVue from 'primevue/config'
import Aura from '@primeuix/themes/aura'

import App from './App.vue'
import router from './router'

import { createI18n } from 'vue-i18n'

import Button from "primevue/button"
import Card from "primevue/card";

import fr from "@/locale/fr.ts";
import en from "@/locale/en.ts";

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
    }
})

app.component('Button', Button)
app.component('Card', Card)

app.mount('#app')
