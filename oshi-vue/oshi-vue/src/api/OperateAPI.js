import instance from "@/utils/index.js";

// 获取CPU负载数据
export const getOperateSysInfo = async () => {
    const res = await instance.get("/operate/info");
    return res.data;
};
