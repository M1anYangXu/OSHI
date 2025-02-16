<template>
  <a-row :gutter="16">
    <!-- 用户信息 -->
    <a-col :span="8">
      <a-card title="用户信息" :bordered="false">
        <a-descriptions :column="1">
          <a-descriptions-item label="用户名">
            <a-tag>{{userinfo.username}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="主机名">
            <a-tag>{{userinfo.host}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="输出设备">
            <a-tag>{{userinfo.terminalDevice}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="系列号">
            <a-tag>{{userinfo.serialNumber}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="登录时间">
            <a-tag>{{userinfo.loginTime}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="IP4地址">
            <a-badge status="success" :text="userinfo.ipAddress" />
          </a-descriptions-item>
        </a-descriptions>
      </a-card>
    </a-col>
    
    <!-- 操作系统信息 -->
    <a-col :span="8">
      <a-card title="操作系统信息" :bordered="false">
        <a-descriptions :column="1">
          <a-descriptions-item label="系统名">
            <a-tag>{{operateSys.family}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="系统生产商">
            <a-tag>{{operateSys.manufacturer}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="系统版本">
            <a-tag>{{operateSys.version}}</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="位数">
            <a-tag>{{operateSys.bitness}}位</a-tag>
          </a-descriptions-item>
          <a-descriptions-item label="启动时间">
            <a-tag>{{Math.floor(operateSys.uptime  / 3600) }}小时,{{Math.floor(operateSys.uptime  % 3600 / 60) }}分钟</a-tag>
          </a-descriptions-item>
        </a-descriptions>
      </a-card>
    </a-col>

    

<!--  &lt;!&ndash; 网卡信息 &ndash;&gt;-->
<!--  <a-row :gutter="16" style="margin-top: 16px;">-->
<!--    <a-col :span="24">-->
<!--      <a-card title="网卡信息" :bordered="false">-->
<!--        <a-table :columns="networkColumns" :data="networkInfo"/>-->
<!--      </a-card>-->
<!--    </a-col>-->
  </a-row>
</template>

<script setup>
import {getUserinfo} from "@/api/UserAPI.js";
import {getOperateSysInfo} from "@/api/OperateAPI.js";
import {onMounted, ref} from "vue";

const userinfo = ref({})
const operateSys = ref({})

onMounted(()=>{
  // 用户信息
  try {
    getUserinfo().then(res => {
      userinfo.value = res
    })
  } catch (error) {
    console.error('获取用户信息失败:', error);
  }
  // 操作系统信息
  try {
    getOperateSysInfo().then(res => {
      operateSys.value = res
    })
  } catch (error) {
    console.error('获取操作系统信息失败:', error);
  }
})


//const networkColumns = [
//  {title: '网卡名称', dataIndex: 'name', slotName: 'name'},
//  {title: 'IP 地址', dataIndex: 'ip', slotName: 'ip'},
//  {title: 'MAC 地址', dataIndex: 'mac', slotName: 'mac'},
//];
//
//const networkInfo = [
//  {name: 'eth0', ip: '192.168.1.100', mac: '00:1A:2B:3C:4D:5E'},
//  {name: 'wlan0', ip: '192.168.2.101', mac: '00:50:56:C0:00:01'},
//];
</script>


<style scoped>

</style>