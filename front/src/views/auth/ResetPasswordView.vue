<script>
import authenticationService from '@/services/authenticationService';
import { InputText, Password } from 'primevue';
import { useVuelidate } from '@vuelidate/core';
import { required, email, minLength, requiredIf } from '@vuelidate/validators';

export default {
  setup () {
    return { v$: useVuelidate() }
  },
  components: {
    InputText,
    Password
  },
  validations: {
    email: { required: requiredIf(function() { return this.token === undefined }), email },
    resetDTO: {
      password: {
        required: requiredIf(function() { return this.token !== undefined }),
        minLength: minLength(6)
      },
      confirmPassword: {
        required: requiredIf(function() { return this.token !== undefined }),
      }
    }
  },
  data() {
    return {
      email: '',
      token: undefined,
      resetDTO: {
        password: '',
        confirmPassword: '',
        token: ''
      }
    };
  },
  mounted() {
    this.token = this.$route.query.token;
  },
  methods: {
    sendResetPasswordEmail() {
      this.v$.$reset();
      this.v$.$touch();
      
      if (this.v$.$error) {
        this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.form.invalid'), life: 3000 });
        return;
      }

      authenticationService.sendResetPasswordEmail(this.email)
        .then((data) => {
          this.$toast.add({ severity: 'success', summary: this.$t('toast.success'), detail: this.$t('toast.messages.resetPasswordEmail.success'), life: 3000 });
          this.$router.push({ name: 'login' });
        })
        .catch(() => {
          this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.resetPasswordEmail.error'), life: 3000 });
        });
    },
    resetPassword() {
      this.v$.$reset();
      this.v$.$validate();
      
      if (this.v$.$error) {
        this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.form.invalid'), life: 3000 });
        return;
      }

      this.resetDTO.token = this.token;
      authenticationService.resetPassword(this.resetDTO)
        .then(() => {
          this.$toast.add({ severity: 'success', summary: this.$t('toast.success'), detail: this.$t('toast.messages.resetPassword.success'), life: 3000 });
          this.$router.push({ name: 'login' });
        })
        .catch(() => {
          this.$toast.add({ severity: 'error', summary: this.$t('toast.error'), detail: this.$t('toast.messages.resetPassword.error'), life: 3000 });
        });
    }
  }
};
</script>

<template>
  <template v-if="token">
    <Card style="width: 35rem; overflow: hidden" class="mx-auto mt-10">
      <template #title>{{ $t('resetPassword.title') }}</template>
      <template #content>
        <p class="mb-3">{{ $t('resetPassword.description_2') }}</p>
        <Password v-model="resetDTO.password" :invalid="v$?.resetDTO?.password?.$error" :placeholder="$t('resetPassword.newPassword')" class="w-full mb-3" :promptLabel="$t('password.prompt')" :weakLabel="$t('password.weak')" :mediumLabel="$t('password.average')" :strongLabel="$t('password.strong')" />
        <Password v-model="resetDTO.confirmPassword" :invalid="v$?.resetDTO?.confirmPassword?.$error" :placeholder="$t('resetPassword.confirmPassword')" class="w-full mb-3" :promptLabel="$t('password.prompt')" :weakLabel="$t('password.weak')" :mediumLabel="$t('password.average')" :strongLabel="$t('password.strong')" />
      </template>
      <template #footer>
        <div class="flex gap-4 mt-1">
          <Button @click="resetPassword" :label="$t('resetPassword.submit')" class="w-full" />
        </div>
      </template>
    </Card>
  </template>
  <template v-else>
    <Card style="width: 35rem; overflow: hidden">
      <template #title>{{ $t('resetPassword.title') }}</template>
      <template #content>
        <p class="mb-3">{{ $t('resetPassword.description') }}</p>
        <InputText v-model="email" :invalid="v$?.email.$error" :placeholder="$t('resetPassword.email')" class="w-full mb-3" />
      </template>
      <template #footer>
        <div class="flex gap-4 mt-1">
          <Button @click="sendResetPasswordEmail" :label="$t('resetPassword.submit')" class="w-full" />
        </div>
      </template>
    </Card>
  </template>
</template>

<style scoped>

</style>