import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import HeaderComponent from './HeaderComponent'

class WelcomeComponent extends Component{

    render(){
        return(
            <div>
                <HeaderComponent/>
                <h1>Welcome {this.props.match.params.name} ! </h1>
                <div>
                    Click <Link to="/employees">here</Link> to see your employees.
                </div>
            </div>
            
        )
    }
}

export default WelcomeComponent