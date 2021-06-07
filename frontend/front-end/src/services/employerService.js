import axios from "../axios/axios"

export default class EmployerService{
getEmployer(){
    return axios.get("/employers/getall")
    }

}