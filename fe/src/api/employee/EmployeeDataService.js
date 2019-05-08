import axios from 'axios'

class EmployeeDataService{

    retrieveAllemployees(username){
        return axios.get(`http://localhost:8080/jpa/users/${username}/employees`)
    }

    /* deleteemployee(username, id){
        return axios.delete(`http://localhost:8080/jpa/users/${username}/employees/${id}`)
    }*/

    retrieveemployee(username, id){
        return axios.get(`http://localhost:8080/jpa/users/${username}/employees/${id}`)
    }

    updateemployee(username, id, employee){
        return axios.put(`http://localhost:8080/jpa/users/${username}/employees/${id}`, employee)
    } 

    createemployee(username, employee){
        return axios.post(`http://localhost:8080/jpa/users/${username}/employees`, employee)
    }
}

export default new EmployeeDataService()