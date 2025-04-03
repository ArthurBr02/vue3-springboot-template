<script>
import { InputText, Select, Password, Button, FileUpload, Dialog } from 'primevue';
import DefaultSettings from '../../components/template/DefaultSettings.vue';
import { getUser } from '../../mixins/user';
import authenticationService from '../../services/authenticationService';
import userService from '../../services/userService';
import ficService from '@/services/ficService';
import { required, email } from '@vuelidate/validators';
import { useVuelidate } from '@vuelidate/core';

export default {
    setup () {
        return { v$: useVuelidate() }
    },
    components: {
        DefaultSettings,
        InputText,
        Password,
        Select,
        FileUpload
    },
    data() {
        return {
            currentUser: {},
            src: undefined,
            file: undefined,
        }
    },
    validations: {
        currentUser: {
            firstName: { required },
            lastName: { required },
            email: { required, email },
            locale: { required }
        }
    },
    mounted() {
        this.currentUser = this.getUser();
        ficService.getProfilePictureByUserId(this.currentUser.id)
            .then((data) => {
                if(data.size > 0) this.src = URL.createObjectURL(data);
            })
            .catch(() => {
                this.src = undefined;
            });
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
        },
        updateUser() {
            this.v$.$reset();
            this.v$.$validate();

            if (this.v$.$error) {
                this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.form.invalid'), life: 3000 });
                return;
            }

            let dto = {
                firstName: this.currentUser.firstName,
                lastName: this.currentUser.lastName,
                email: this.currentUser.email,
                locale: this.currentUser.locale
            };
            
            userService.update(dto)
                .then((data) => {
                    localStorage.setItem('token', data.token);
                    this.currentUser = this.getUser();
                    this.$i18n.locale = this.currentUser.locale;
                    this.$toast.add({ severity: 'success', summary: this.$t('toast.success'), detail: this.$t('toast.messages.settingsUserUpdate.success'), life: 3000 });
                })
                .catch((error) => {
                    console.log(error);
                    if (error.response.status === 409) {
                        this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.settingsUserUpdate.emailAlreadyUsed'), life: 3000 });
                        return;
                    }
                    this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.settingsUserUpdate.error'), life: 3000 });
                });
        },
        onFileSelect(event) {
            const file = event.files[0];

            this.file = file;
            this.src = URL.createObjectURL(file);
        },
        uploadProfilePicture() {
            if (!this.file) {
                this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.settingsProfilePictureUpload.noFile'), life: 3000 });
                return;
            }
            
            ficService.uploadProfilePicture(this.file)
                .then(() => {
                    this.$toast.add({ severity: 'success', summary: this.$t('toast.success'), detail: this.$t('toast.messages.settingsProfilePictureUpload.success'), life: 3000 });
                })
                .catch(() => {
                    this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.settingsProfilePictureUpload.error'), life: 3000 });
                });
        },
        confirmDeleteProfilePicture() {
            this.$confirm.require({
                message: this.$t('settings.user.deleteConfirmation'),
                header: this.$t('settings.user.deleteConfirmationTitle'),
                icon: 'pi pi-exclamation-triangle',
                rejectProps: {
                    label: this.$t('settings.user.cancel'),
                    severity: 'secondary',
                    outlined: true
                },
                acceptProps: {
                    label: this.$t('settings.user.delete'),
                    severity: 'danger',
                },
                accept: () => {
                    ficService.deleteProfilePicture()
                        .then(() => {
                            this.src = undefined;
                        });
                    this.$toast.add({ severity: 'success', summary: this.$t('toast.messages.settingsProfilePictureDelete.successTitle'), detail: this.$t('toast.messages.settingsProfilePictureDelete.success'), life: 3000 });
                },
                reject: () => {
                    this.$toast.add({ severity: 'error', summary: this.$t('toast.messages.settingsProfilePictureDelete.errorTitle'), detail: this.$t('toast.messages.settingsProfilePictureDelete.error'), life: 3000 });
                }
            });
        }
    },
}
</script>

<template>
    <DefaultSettings selected="user">
        <div class="mt-4">
            <div class="grid md:grid-cols-2 grid-cols-1 gap-4 ">
                <InputText v-model="currentUser.firstName" :invalid="v$.currentUser.firstName.$error" :placeholder="$t('settings.user.firstName')" />
                <InputText v-model="currentUser.lastName" :invalid="v$.currentUser.lastName.$error" :placeholder="$t('settings.user.lastName')" />
                <InputText v-model="currentUser.email" :invalid="v$.currentUser.email.$error" :placeholder="$t('settings.user.email')" />
                <Select v-model="currentUser.locale" :invalid="v$?.currentUser?.locale?.$error" :placeholder="$t('settings.user.locale')" optionLabel="label" optionValue="value" :options="[{label: 'Français', value: 'fr'}, {label: 'English', value: 'en'}]" class="w-full" />
                <Button @click="updateUser()" class="md:w-1/4 w-full bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded md:col-span-2">{{ $t('settings.user.submit') }}</button>
            </div>
            <div class="flex flex-col gap-4 mt-4">
                <span class="text-2xl font-medium block *:w-full col-span-2">{{ $t('settings.user.profilePicture') }}</span>
                <div class="flex flex-row gap-4">
                    <FileUpload :chooseLabel="$t('fileUpload.choose')" mode="basic" accept="image/*" :maxFileSize="1000000" @select="onFileSelect" customUpload auto severity="secondary" class="p-button-outlined" />
                    <Button @click="uploadProfilePicture" class="p-button-outlined">{{ $t('settings.user.upload') }}</button>
                </div>
                <div v-if="src">
                    <img :src="src" :alt="$t('settings.user.profilePicture')" class="shadow-md rounded-xl w-full sm:w-64" />
                    <Button @click="confirmDeleteProfilePicture()" severity="danger" class="mt-4 p-button-outlined">{{ $t('settings.user.delete') }}</button>
                </div>
            </div>
            <div class="grid md:grid-cols-2 grid-cols-1 gap-4 mt-4">
                <span class="text-2xl font-medium block *:w-full col-span-2">{{ $t('settings.user.changePassword') }}</span>
                <Button @click="askForResetPwdMail()" :label="$t('settings.user.askForResetPwdMail')" class="lg:w-1/2 w-full" />
            </div>
        </div>
    </DefaultSettings>
</template>