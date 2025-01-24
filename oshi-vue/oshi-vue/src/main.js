import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
// 引入字节的UI
import '@arco-design/web-vue/dist/arco.css'
import ArcoVue from "@arco-design/web-vue";

const app = createApp(App)

app.use(createPinia())
app.use(ArcoVue)
app.use(router)

app.mount('#app')
