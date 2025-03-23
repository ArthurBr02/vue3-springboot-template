<script>
import authenticationService from '@/services/authenticationService';
import { InputText } from 'primevue';

export default {
  components: {
    InputText
  },
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    login() {
      authenticationService.login(this.email, this.password)
        .then((data) => {
          localStorage.setItem('token', data.token);
          this.$router.push({ name: 'home' });
        })
        .catch(() => {
          this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.login.error'), life: 3000 });
        });
    },
    goToRegister() {
      this.$router.push({ name: 'register' });
    },
    goToResetPassword() {
      this.$router.push({ name: 'resetPassword' });
    }
  }
};

</script>

<template>
  <Card style="width: 35rem; overflow: hidden" class="mx-auto mt-10">
    <template #title>{{ $t('login.title') }}</template>
    <template #content>
      <InputText v-model="email" :placeholder="$t('login.email')" class="w-full mb-3" />
      <InputText v-model="password" :placeholder="$t('login.password')" type="password" class="w-full" />
    </template>
    <template #footer>
      <div>
        <a @click="goToResetPassword" href="#">{{ $t('login.forgot') }}?</a>
      </div>
      <div class="flex gap-4 mt-1">
        <Button @click="goToRegister" :label="$t('login.register')" severity="secondary" outlined class="w-full" />
        <Button @click="login" :label="$t('login.submit')" class="w-full" />
      </div>
    </template>
  </Card>

</template>

<style scoped>

</style>