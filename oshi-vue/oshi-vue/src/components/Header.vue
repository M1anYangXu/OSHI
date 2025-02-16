<template>
  <div class="menu-demo">
    <a-menu mode="horizontal" :default-selected-keys="['/']" @menu-item-click="handleMenuClick">
      <a-menu-item key="/">首页</a-menu-item>
      <a-menu-item key="/cpuload">CPU监控</a-menu-item>
<!--      <a-menu-item key="3">Cloud Service</a-menu-item>-->
<!--      <a-menu-item key="4">Cooperation</a-menu-item>-->
    </a-menu>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
const handleMenuClick = (key) => {
  router.push(key)
}
</script>


<style scoped>
.menu-demo {
  box-sizing: border-box;
  width: 100%;
  background-color: var(--color-neutral-2);
}
</style>