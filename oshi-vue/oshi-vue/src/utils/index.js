import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:8888/',
    timeout: 3000,
    headers: { "Content-Type": "application/json" },
});


instance.interceptors.request.use(
    function (config) {
        return config;
    },
    function (error) {
        return Promise.reject(error);
    }   
);


instance.interceptors.response.use(
    function (response) {
        const res = response.data;
        if (res.code === 200){
            return res;
        }
        return Promise.reject(res);
    },
    function (error) {
        return Promise.reject(error);
    }
);

export default instance