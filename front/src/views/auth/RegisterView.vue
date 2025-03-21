<script>
import { Select, InputText, Password, Toast } from 'primevue';
import authenticationService from '@/services/authenticationService';
import { useVuelidate } from '@vuelidate/core';
import { required, email, minLength } from '@vuelidate/validators';

export default {
  setup () {
    return { v$: useVuelidate() }
  },
  components: {
    InputText,
    Password,
    Select,
    Toast
  },
  data() {
    return {
      dto: {
        email: '',
        password: '',
        confirmPassword: '',
        firstName: '',
        lastName: '',
        locale: 'fr',
      }
    };
  },
  validations: {
    dto: {
      email: { required, email },
      password: { required, minLength: minLength(6) },
      confirmPassword: { required },
      firstName: { required },
      lastName: { required },
      locale: { required }
    }
  },
  methods: {
    register() {
      this.v$.$reset();
      this.v$.$validate();
      
      if (this.v$.$error) {
        this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.form.invalid'), life: 3000 });
        return;
      }

      if (this.checkPassword()) {
        authenticationService.register(this.dto)
          .then(() => {
            this.$toast.add({ severity: 'success', summary: this.$t('toast.success'), detail: this.$t('toast.messages.register.success'), life: 3000 });
            this.$router.push({ name: 'login' });
          })
          .catch(() => {
            this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.register.error'), life: 3000 });
          });
      } else {
        this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.password.notMatching'), life: 3000 });
      }
    },
    checkPassword() {
      return this.dto.password === this.dto.confirmPassword;
    }
  }
};

</script>

<template>
  <Card style="width: 35rem; overflow: hidden">
    <template #title>{{ $t('register.title') }}</template>
    <template #content>
      <div class="flex gap-3 flex-col">
        <InputText v-model="dto.firstName" :invalid="v$?.dto?.firstName?.$error" :placeholder="$t('register.firstName')" class="w-full" />
        <InputText v-model="dto.lastName" :invalid="v$?.dto?.lastName?.$error" :placeholder="$t('register.lastName')" class="w-full" />
        <InputText v-model="dto.email" :invalid="v$?.dto?.email?.$error" :placeholder="$t('register.email')" class="w-full" />
        <Password v-model="dto.password" :invalid="v$?.dto?.password?.$error" :placeholder="$t('register.password')" class="w-full" :promptLabel="$t('password.prompt')" :weakLabel="$t('password.weak')" :mediumLabel="$t('password.average')" :strongLabel="$t('password.strong')" />
        <Password v-model="dto.confirmPassword" :invalid="v$?.dto?.confirmPassword?.$error" :placeholder="$t('register.confirmPassword')" class="w-full" :promptLabel="$t('password.prompt')" :weakLabel="$t('password.weak')" :mediumLabel="$t('password.average')" :strongLabel="$t('password.strong')" />
        <Select v-model="dto.locale" :invalid="v$?.dto?.locale?.$error" :placeholder="$t('register.locale')" optionLabel="label" optionValue="value" :options="[{label: 'Français', value: 'fr'}, {label: 'English', value: 'en'}]" class="w-full" />
      </div>
    </template>
    <template #footer>
      <div class="flex gap-4 mt-1">
        <Button @click="register()" :label="$t('register.submit')" class="w-full" />
      </div>
    </template>
  </Card>
</template>

<style scoped>

</style>