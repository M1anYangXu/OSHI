import instance from "@/utils/index.js";

// 获取CPU负载数据
export const getCpuLoad = async () => {
  return await instance.get("/cpu/load");
};
