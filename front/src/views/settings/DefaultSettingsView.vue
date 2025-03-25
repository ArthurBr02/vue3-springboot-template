<script>
import DefaultPageContent from '@/components/template/DefaultPageContent.vue';
import { Card } from 'primevue';

export default {
    props: {
        selected: {
            type: String,
            required: true
        }
    },
    components: {
        DefaultPageContent,
        Card
    },
    data() {
        return {
            settings: {
                menu: [
                    { label: 'settings.menu.general', icon: 'pi pi-fw pi-cog', selectionLabel: 'general' },
                    { label: 'settings.menu.user', icon: 'pi pi-fw pi-user', selectionLabel: 'user' },
                    { label: 'settings.menu.security', icon: 'pi pi-fw pi-lock', selectionLabel: 'security' },
                    { label: 'settings.menu.notifications', icon: 'pi pi-fw pi-bell', selectionLabel: 'notifications' },
                    { label: 'settings.menu.appearance', icon: 'pi pi-fw pi-eye', selectionLabel: 'appearance' },
                    { label: 'settings.menu.language', icon: 'pi pi-fw pi-globe', selectionLabel: 'language' },
                    { label: 'settings.menu.about', icon: 'pi pi-fw pi-info-circle', selectionLabel: 'about' }
                ]
            }
        }
    },
    methods: {
        isSettingSelected(selectionLabel) {
            return selectionLabel === this.selected;
        }
    }
}
</script>

<template>
    <DefaultPageContent :title="$t('settings.title')">
        <div class="flex flex-row m-4 h-lvh gap-4">
            <div class="flex-1/4">
                <Card class="min-h-full h-auto no-content-padding-card">
                    <template #content>
                        <ul>
                            <li v-for="setting in settings.menu" :key="setting.label" class="mb-2">
                                <router-link 
                                class="flex items-center p-2 text-gray-900 rounded-lg hover:bg-gray-100 group" 
                                :to="'/settings/' + setting.selected">
                                    <i v-if="setting.icon" 
                                    :class="setting.icon" 
                                    class="w-5 h-5 text-gray-500 transition duration-75 group-hover:text-gray-900"></i>
                                    <span class="ml-2 text-sm font-medium" :class="{ 'text-green-500': isSettingSelected(setting.selectionLabel) }">
                                        {{ $t(setting.label) }}
                                    </span>
                                </router-link>
                            </li>
                        </ul>
                    </template>
                </Card>
            </div>
            <div class="flex-3/4">
                <Card class="min-h-full h-auto no-content-padding-card">
                    <template #header>
                        <span class="text-2xl font-medium block *:w-full">{{ $t('settings.menu.' + selected) }}</span>
                    </template>
                    <template #content>
                        <slot></slot>
                    </template>
                </Card>
            </div>
        </div>
    </DefaultPageContent>
</template>