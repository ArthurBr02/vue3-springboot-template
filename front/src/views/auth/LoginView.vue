<script>
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
      // this.$store.dispatch('auth/login', { email: this.email, password: this.password });
    },
    goToRegister() {
      this.$router.push({ name: 'register' });
    }
  }
};

</script>

<template>
  <Card style="width: 25rem; overflow: hidden">
    <!-- <template #header>
      <img alt="user header" src="/favicon.ico?url" />
    </template> -->
    <template #title>{{ $t('login.title') }}</template>
    <template #content>
      <InputText v-model="email" :placeholder="$t('login.email')" class="w-full mb-3" />
      <InputText v-model="password" :placeholder="$t('login.password')" type="password" class="w-full" />
    </template>
    <template #footer>
      <div>
        <a @click="goToRegister" href="#">{{ $t('login.forgot') }}?</a>
      </div>
      <div class="flex gap-4 mt-1">
        <Button :label="$t('login.register')" severity="secondary" outlined class="w-full" />
        <Button :label="$t('login.submit')" class="w-full" />
      </div>
    </template>
  </Card>

</template>

<style scoped>

</style>