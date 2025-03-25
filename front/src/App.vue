<script>
import { RouterView } from 'vue-router'
import Toast from 'primevue/toast'
import ConfirmDialog from 'primevue/confirmdialog'
import SideBar from '@/components/sidebar/SideBar.vue'

export default {
  components: {
    Toast,
    SideBar,
    RouterView,
    ConfirmDialog
  }
}
</script>

<template>
  <div class="w-full flex justify-center" style="max-height: 100vh;">
    <Toast />
    <ConfirmDialog></ConfirmDialog>
    <div class="mb-3 flex justify-center align-center">
      <RouterView />
    </div>
    <SideBar />
  </div>
</template>

<style scoped>
</style>
