import axios from 'axios';// axios to hit any server frm frontend

const api= axios.create({baseURL:"localhost://8080/api/v1"})

api.interceptorsnterceptors.request.use((config)=>{
    const token=localStorage.getItem("token")
    if(token)
        config.header.Authorization='Bearer ${token}'
    return config;
});
export default Api;