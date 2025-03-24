<script>
import { InputText, Select, Password, Button } from 'primevue';
import DefaultSettingsView from './DefaultSettingsView.vue';
import { getUser } from '../../mixins/user';
import authenticationService from '../../services/authenticationService';

export default {
    components: {
        DefaultSettingsView,
        InputText,
        Password,
        Select
    },
    data() {
        return {
            currentUser: {}
        }
    },
    mounted() {
        this.currentUser = this.getUser();
    },
    methods: {
        getUser,
        askForResetPwdMail() {
            authenticationService.sendResetPasswordEmail(this.currentUser.email)
                .then(() => {
                    this.$toast.add({ severity: 'success', summary: this.$t('toast.success'), detail: this.$t('toast.messages.settingsResetPasswordEmail.success'), life: 3000 });
                })
                .catch(() => {
                    this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.resetPasswordEmail.error'), life: 3000 });
                });
        }
    }
}
</script>

<template>
    <DefaultSettingsView selected="user">
        <div class="mt-4">
            <div class="grid md:grid-cols-2 grid-cols-1 gap-4 ">
                <InputText v-model="currentUser.firstName" :placeholder="$t('settings.user.firstName')" />
                <InputText v-model="currentUser.lastName" :placeholder="$t('settings.user.lastName')" />
                <InputText v-model="currentUser.email" :placeholder="$t('settings.user.email')" />
                <Select v-model="currentUser.locale" :invalid="v$?.currentUser?.locale?.$error" :placeholder="$t('settings.user.locale')" optionLabel="label" optionValue="value" :options="[{label: 'Français', value: 'fr'}, {label: 'English', value: 'en'}]" class="w-full" />
                <Button @click="updateUser()" class="md:w-1/4 w-full bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded md:col-span-2">{{ $t('settings.user.submit') }}</button>
            </div>
            <div class="grid md:grid-cols-2 grid-cols-1 gap-4 mt-4">
                <span class="text-2xl font-medium block *:w-full col-span-2">{{ $t('settings.user.changePassword') }}</span>
                <Button @click="askForResetPwdMail()" :label="$t('settings.user.askForResetPwdMail')" class="w-full" />
            </div>
        </div>
    </DefaultSettingsView>
</template>