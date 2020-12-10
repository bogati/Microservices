import React, { Component } from "react";
import JobCardService from "../services/JobCardService";

class ListJobCardsComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      jobcards: [],
    };
    this.addJobCard = this.addJobCard.bind(this);
    this.deleteTask = this.deleteTask.bind(this);
  }

  deleteTask(id) {
    //make a REST API call
    JobCardService.deleteJobCard(id).then((res) => {
      this.setState({
        jobcards: this.state.jobcards.filter((jobcard) => jobcard.jobId !== id),
      });
    });
  }

  addJobCard() {
    this.props.history.push("/add-jobcard");
  }

  componentDidMount() {
    //this method returns promise, therefore use then
    JobCardService.getJobCards().then((res) => {
      //set the response to the state of the component
      this.setState({ jobcards: res.data });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center"> JobCard (List of Tasks) </h2>
        <div className="row">
          <button
            className="btn btn-primary btn-lg disabled"
            onClick={this.addJobCard}
          >
            Add JobCard
          </button>
        </div>

        <div className="row">
          <table className="table table-striped table-hover ">
            <thead>
              <tr>
                <th> Job Id </th>
                <th> Employee Id</th>
                <th> Customer Id</th>
                <th> Appointment Id</th>
                <th> Vehicle Identification Number</th>
                <th>Todo Services</th>
              </tr>
            </thead>
            <tbody>
              {this.state.jobcards.map((jobcard) => (
                <tr key={jobcard.jobId}>
                  <td>{jobcard.jobId}</td>
                  <td>{jobcard.employeeId}</td>
                  <td>{jobcard.customerId}</td>
                  <td>{jobcard.appointmentId}</td>
                  <td>{jobcard.vechVin} </td>
                  <td>
                    <ul>
                      {jobcard.services.map((service) => (
                        <li key={service.serviceId}>{service.name}</li>
                      ))}
                    </ul>
                  </td>
                  <td>
                    <button
                      className="btn btn-danger"
                      onClick={() => this.deleteTask(jobcard.jobId)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListJobCardsComponent;
