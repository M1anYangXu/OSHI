import { createRouter, createWebHistory } from 'vue-router'
import Home from "@/views/Home.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/cpuload',
      name: 'cpuload',
      component: () => import('@/views/cpu/CpuLoad.vue'),
    }
  ],
})

export default router
