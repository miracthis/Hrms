import axios from "../axios/axios"

export default class CandidateService{
getCandidate(){
    return axios.get("/candidates/getall")
    }

}