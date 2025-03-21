<script>
import { InputText } from 'primevue';

export default {
  components: {
    InputText
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
  }
};

</script>

<template>
  <Card style="width: 25rem; overflow: hidden">
    <!-- <template #header>
      <img alt="user header" src="/favicon.ico?url" />
    </template> -->
    <template #title>{{ $t('register.title') }}</template>
    <template #content>
      <div class="flex gap-3 flex-col">
        <InputText v-model="dto.firstName" :placeholder="$t('register.firstName')" class="w-full" />
        <InputText v-model="dto.lastName" :placeholder="$t('register.lastName')" class="w-full" />
        <InputText v-model="dto.email" :placeholder="$t('register.email')" class="w-full" />
        <InputText v-model="dto.password" :placeholder="$t('register.password')" type="password" class="w-full" />
        <InputText v-model="dto.confirmPassword" :placeholder="$t('register.confirmPassword')" type="password" class="w-full" />
        <Dropdown v-model="dto.locale" :options="[{label: 'Français', value: 'fr'}, {label: 'English', value: 'en'}]" optionLabel="label" placeholder="Select a Locale" class="w-full" />
      </div>
    </template>
    <template #footer>
      <div class="flex gap-4 mt-1">
        <Button :label="$t('register.submit')" class="w-full" />
      </div>
    </template>
  </Card>

</template>

<style scoped>

</style>