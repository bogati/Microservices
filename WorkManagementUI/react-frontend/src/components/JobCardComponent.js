import React from 'react';
import JobCardService from '../services/JobCardService';

class JobCardComponent extends React.Component{
    
    constructor(props){
        super(props);
        this.state = {
            jobcards:[]

        }
    }

    componentDidMount(){
        JobCardService.getJobCards().then((response) =>{
            this.setState({jobcards: response.data})
        });
    }

    render(){

        return(

            <div>

                <h1 className="text-center"> Job Cards List </h1>
                <table className = "table table-striped"> 
                <thead>
                    <tr>
                        <td> Job Id </td>
                        <td> Employee Id</td>
                        <td>Customer Id</td>
                        <td>Appointment Id</td>
                        <td>Vehicle Identification Number</td>

                    </tr>
                </thead> 
                <tbody>
                    {
                        this.state.jobcards.map(

                            jobcard =>
                            <tr key = {jobcard.jobId}>
                                <td>{jobcard.jobId}</td>
                                <td>{jobcard.employeeId}</td>
                                <td>{jobcard.customerId}</td>
                                <td>{jobcard.appointmentId}</td>
                                <td>{jobcard.vechVin} </td>
                            </tr>
                        )


                    }



                </tbody>


                </table>





            </div>




        )

    } //end of render


}
export default JobCardComponent;