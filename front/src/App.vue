<script>
import { RouterView } from 'vue-router'
import Toast from 'primevue/toast'
import SideBar from '@/components/sidebar/SideBar.vue'

export default {
  components: {
    Toast,
    SideBar,
    RouterView
  }
}
</script>

<template>
  <div class="w-full flex justify-center">
    <Toast />
    <div class="mb-3 flex justify-center align-center">
      <RouterView />
    </div>
    <SideBar />
  </div>
</template>

<style scoped>
</style>
