import axios from 'axios'


const JOBCARDS_REST_API_BASEURL ='http://localhost:9000/api/jobcards/jobcard';

//const JOBCARDS_REST_API_BASEURL ='http://localhost:8085/jobcard';




class JobCardService{

    getJobCards(){
        return axios.get(JOBCARDS_REST_API_BASEURL);
    }

    createJobCard(jobcard){
        return axios.post(JOBCARDS_REST_API_BASEURL,jobcard)
    }
    deleteJobCard(jobId){
        return axios.delete(JOBCARDS_REST_API_BASEURL+'/'+jobId)

    }
}
//exporting the object of the class so that you can directly use object of the class inside component
export default new JobCardService();