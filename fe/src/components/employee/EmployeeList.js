import React, {Component} from 'react'
import HeaderComponent from './HeaderComponent'
import EmployeeDataService from '../../api/employee/EmployeeDataService';
import AuthenticationService from './AuthenticationService';
import moment from 'moment'
class EmployeeList extends Component{

    constructor(props){
        super(props);
        this.state={
            employees: [],
            message : ''
        }

        this.refreshemployees = this.refreshemployees.bind(this)
        this.createemployee = this.createemployee.bind(this)
    }

    componentDidMount(){
       this.refreshemployees()
    }

    refreshemployees(){
        let user = AuthenticationService.getLoggedInUser();
        EmployeeDataService.retrieveAllemployees(user).then(response => {
            this.setState({
                employees: response.data
            })
        })
    }


    createemployee(){
        this.props.history.push('/employee/-1')
    }

    render(){
        return(
            <div>
            <HeaderComponent/>
            <div className="container">
                <h1>List employees</h1>
                <span style={{float:'right', padding:'5px'}}><button onClick={this.createemployee} className="btn btn-success">Add</button></span>
                {this.state.message ?<div className="alert alert-success">{this.state.message}</div> : ''}
                <table className="table">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Gender</th>
                            <th>DOB</th>
                            <th>Department</th>
                            <th>Age</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.employees.map(employee => (
                            <tr key={employee.id}>
                                <td>{employee.first_Name}</td>
                                <td>{employee.last_Name}</td>
                                <td>{employee.gender}</td>
                                <td>{moment(employee.targetDate).format('YYYY-MM-DD')}</td>
                                <td>{employee.dept}</td>
                                <td>{employee.age}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                </div>
            </div>
        )
    }
}

export default EmployeeList