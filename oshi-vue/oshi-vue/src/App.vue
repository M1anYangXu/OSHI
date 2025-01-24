<template>
  <div class="layout-demo">
    <a-layout style="height: 100vh;">
      <a-layout-header>
        <Header/>
      </a-layout-header>
      
      <a-layout-content>
        <RouterView/>
      </a-layout-content>
      
      <a-layout-footer>
        
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup>
import Header from "@/components/Header.vue";
</script>

<style scoped>
.layout-demo :deep(.arco-layout-header),
.layout-demo :deep(.arco-layout-footer),
.layout-demo :deep(.arco-layout-sider-children),
.layout-demo :deep(.arco-layout-content) {
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: var(--color-white);
  font-size: 16px;
  font-stretch: condensed;
  text-align: center;
}


.layout-demo :deep(.arco-layout-header),
.layout-demo :deep(.arco-layout-footer) {
  height: 64px;
}

.layout-demo :deep(.arco-layout-sider) {
  width: 206px;
}

.layout-demo :deep(.arco-layout-content) {
}
</style>
