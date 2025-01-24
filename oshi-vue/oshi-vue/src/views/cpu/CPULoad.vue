<template>
    <a-space wrap>
      <!-- ${i} 1~16 -->
      <div :id="`cpu-${i}`" style="width: 200px;height: 370px;background-color: white;border: 1px solid black;" v-for="i in 16">
      </div>
    </a-space>
</template>

<script setup>
import * as echarts from 'echarts';
import {onMounted, ref} from "vue";
import {getCpuLoad} from "@/api/cpuloadApi.js";


const chartDoms = []
const cpuAllData = ref([])
onMounted(()=>{
  // 初始化一次
  initChart();
  // 获取CPU负载数据
  getCpuLoadData()
})

const initChart = () => {
  for (let i = 1; i <= 16; i++) {
    let chartDom = document.getElementById(`cpu-${i}`);
    let myChart = echarts.init(chartDom);
    chartDoms.push(myChart)  
  }
}

const getCpuLoadData = async () => {
  let res = await getCpuLoad()
  let data = res.data;
  for (let i = 0; i < data.length; i++) {
    // 初始化16个cpu的数值
    if (!cpuAllData.value[i]) {
      cpuAllData.value[i] = []
    }
    cpuAllData.value[i].push(data[i])
    
    if (cpuAllData.value[i].length > 50) {
      // 始终保留100个数据
      cpuAllData.value[i].shift()
      console.log(i+":"+cpuAllData.value[i].length)
    }
    
    
    drawCpuLoad(i+1,cpuAllData.value[i])
  }
  await getCpuLoadData()
}

const drawCpuLoad = (cpuIndex,cpudata) => {
  let myChart = chartDoms[cpuIndex-1];
  let option;

  option = {
    title: {
      text: `CPU-${cpuIndex}`,
      textStyle: {
        fontSize:15
      }
    },
    grid: {left: 0, right: 0, top: 5, bottom: 0},
    xAxis: {
      show: false,
      type: 'category',
    },
    yAxis: {
      show: false,
      type: 'value',
      min: 0,
      max: 1
    },
    series: [
      {
        data: cpudata,
        type: 'line',
        symbol: 'none',
        smooth: true,
        areaStyle: {}
      }
    ]
  };

  myChart.setOption(option);
}

</script>

<style scoped>

</style>
