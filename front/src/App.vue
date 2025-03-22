<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import Toast from 'primevue/toast'
import SideBar from '@/components/SideBar.vue'
</script>

<template>
  <Toast />
  <SideBar />
  <div class="mt-3 mb-3 flex justify-center align-center">
    <RouterView />
  </div>
</template>

<style scoped>
</style>
