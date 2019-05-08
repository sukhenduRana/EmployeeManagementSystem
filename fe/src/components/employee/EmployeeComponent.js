import React, {Component} from 'react'
import moment from 'moment'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import EmployeeDataService from '../../api/employee/EmployeeDataService';
import AuthenticationService from './AuthenticationService';
import HeaderComponent from './HeaderComponent';

class employeeComponent extends Component{

    constructor(props){
        super(props)
        this.state = {
            id : this.props.match.params.id,
            fName : '',
            lName : '',
            gender : '',
            dob : '',
            dept:'',
            age: 0
        }

        this.submit = this.submit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount(){
        let user = AuthenticationService.getLoggedInUser()
        EmployeeDataService.retrieveemployee(user, this.state.id)
        .then(response => {
            console.log(response)
            this.setState({
                fName : response.data.first_Name,
                lName : response.data.last_Name,
                gender: response.data.gender,
                dob : moment(response.data.dob).format('YYYY-MM-DD'),
                dept : response.data.dept,
                age : response.data.age
            })
        })
    }
    submit(values){
        console.log('submitting...')
        let user = AuthenticationService.getLoggedInUser()
        let employee = {
            id: -1,
            first_Name: values.fName,
            last_Name: values.lName,
            gender: values.gender,
            dob: moment(values.dob).format('YYYY-MM-DD'),
            dept: values.dept,
            age : values.age
        }

        if(this.state.id == -1){
            EmployeeDataService.createemployee(user, employee)
            .then(response => {
                this.props.history.push('/employees')
            })

        } else{
            EmployeeDataService.updateemployee(user, this.state.id, employee)
                .then(response => {
                    this.props.history.push('/employees')
                })
        }
    }
    
    validate(values){
        let errors = {}
        if(!values.fName){
            errors.fName = 'Enter first name'
        }else if(values.fName.length < 4){
            errors.fName = 'Please enter atleast 5 characters'
        }

        if(!values.lName){
            errors.lName = 'Enter last name'
        }else if(values.lName.length < 5){
            errors.lName = 'Please enter atleast 5 characters'
        }

        if(!values.gender){
            errors.gender = 'Enter gender'
        }else if(values.gender.length < 3){
            errors.gender = 'Please enter atleast 5 characters'
        }

        if(!moment(values.dob).isValid()){
            errors.dob = 'Enter valid date'
        }

        if(!values.dept){
            errors.dept = 'Enter Department'
        }else if(values.gender.length < 1){
            errors.dept = 'Please enter department'
        }

        if(!values.age){
            errors.age = 'Enter Department'
        }else if(values.age < 18){
            errors.age = 'Please enter valid age'
        }
        return errors
    }
    render(){

        let {fName, lName, gender, dob, dept} = this.state
        return(
            <div>
                <HeaderComponent/>
                <h1>Add Employee</h1>
                <div className="container">
                <Formik initialValues={
                    {fName,lName, gender, dob, dept}}
                    onSubmit={this.submit}
                    validate={this.validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                    enableReinitialize={true}>
                    {
                        (props) => (
                            <Form >
                                <ErrorMessage name="fName" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="lName" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="gender" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="dob" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="dept" component="div" className="alert alert-warning"/>
                                <ErrorMessage name="age" component="div" className="alert alert-warning"/>
                                <fieldset className="form-group">
                                    <label>First name</label>
                                    <Field className="form-control" type="text" name="fName"/>
                               </fieldset>
                               <fieldset className="form-group">
                                    <label>Last name</label>
                                    <Field className="form-control" type="text" name="lName"/>
                               </fieldset>
                               <fieldset className="form-group">
                                    <label>Gender</label>
                                    <Field className="form-control" type="text" name="gender"/>
                               </fieldset>
                               <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field className="form-control" type="date" name="dob"/>
                               </fieldset>
                               <fieldset className="form-group">
                                    <label>Department</label>
                                    <Field className="form-control" type="text" name="dept"/>
                               </fieldset>
                               <fieldset className="form-group">
                                    <label>Age</label>
                                    <Field className="form-control" type="text" name="age"/>
                               </fieldset>
                               <button type="submit" className="btn btn-success">Save</button>
                            </Form>
                        )
                    }
                    </Formik>
                </div>
            </div>
        )
    }

}

export default employeeComponent