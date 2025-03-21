<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import Toast from 'primevue/toast'
</script>

<template>
  <Toast />
  <div class="mt-3 mb-3 flex justify-center align-center">
    <RouterView />
  </div>
</template>

<style scoped>
</style>
