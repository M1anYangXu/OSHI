import instance from "@/utils/index.js";

// 获取CPU负载数据
export const getUserinfo = async () => {
    const res = await instance.get("/user/info")
    return res.data;
};
