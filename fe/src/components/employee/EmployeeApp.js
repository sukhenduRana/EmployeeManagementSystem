import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import LoginComponent from './LoginComponent';
import WelcomeComponent from './WelcomeComponent';
import employeeList from './EmployeeList'
import FooterComponent from './FooterComponent';
import LogoutComponent from './LogoutComponent';
import AuthenticatedRoute from './AuthenticatedRoute'
import EmployeeComponent from './EmployeeComponent'

class EmployeeApp extends Component{
    render(){
        return(
            <div className="employeeApp">
                <Router>
                        <Switch>
                            <Route path = "/" exact component={LoginComponent}/>
                            <Route path = "/login" component={LoginComponent}/>
                            <AuthenticatedRoute path = "/welcome/:name" component ={WelcomeComponent}/>
                            <AuthenticatedRoute path = "/employee/:id" component={EmployeeComponent}/>
                            <AuthenticatedRoute path = "/employees" component={employeeList}/>
                            <AuthenticatedRoute path = "/logout" component={LogoutComponent}/>
                            <Route component={ErrorComponent}/>
                        </Switch>
                    <FooterComponent/>
                </Router>
            </div>
        )
    }
}

function ErrorComponent(){
    return(
        <div>Invalid Page</div>
    )
}

export default EmployeeApp