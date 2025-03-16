<script>
export default {
  methods: {
    goHome() {
      this.$router.push({ name: 'home' });
    },
  },
};
</script>

<template>
  <div class="about">
    <h1>This is an about page</h1>
    <Button @click="goHome">Go Home</Button>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
