import React, { Component } from "react";
import JobCardService from "../services/JobCardService";

class CreateJobCardComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      jobId: "",
      employeeId: "",
      customerId: "",
      appointmentId: "",
      vechVin: "",
      service1: {
        checked: false,
        name: "oil change",
      },
      service2: {
        checked: false,
        name: "brake change",
      },
      service3: {
        checked: false,
        name: "full service",
      },
      services: [],
    };
    this.changeJobIdHandler = this.changeJobIdHandler.bind(this);
    this.changeEmployeeIdHandler = this.changeEmployeeIdHandler.bind(this);
    this.changeCusotmerIdHandler = this.changeCusotmerIdHandler.bind(this);

    this.changeVinNumberHandler = this.changeVinNumberHandler.bind(this);
    this.changeVinNumberHandler = this.changeVinNumberHandler.bind(this);
    this.saveTask = this.saveTask.bind(this);
    this.changeAppointmentIdHandler = this.changeAppointmentIdHandler.bind(
      this
    );
  }

  changeJobIdHandler = (event) => {
    this.setState({ jobId: event.target.value });
  };
  changeEmployeeIdHandler = (event) => {
    this.setState({ employeeId: event.target.value });
  };
  changeCusotmerIdHandler = (event) => {
    this.setState({ customerId: event.target.value });
  };
  changeAppointmentIdHandler = (event) => {
    this.setState({ appointmentId: event.target.value });
  };
  changeVinNumberHandler = (event) => {
    this.setState({ vechVin: event.target.value });
  };
  saveTask = (e) => {
    e.preventDefault();
    let jobcard = {
      jobId: this.state.jobId,
      employeeId: this.state.employeeId,
      customerId: this.state.customerId,
      appointmentId: this.state.appointmentId,
      vechVin: this.state.vechVin,
      services: this.state.services,
    };
    console.log("jobcards => " + JSON.stringify(jobcard));

    JobCardService.createJobCard(jobcard).then((res) => {
      this.props.history.push("/jobcards");
    });
  };

  cancel = () => {
    this.props.history.push("/jobcards");
  };

  changeServices = (event) => {
    const { name, checked, value } = event.target;

    this.setState((prev) => ({
      ...prev,
      [name]: {
        ...prev[name],
        checked,
      },
      services: !checked
        ? prev.services.filter((s) => s.name !== value)
        : [...prev.services, { name: value }],
    }));
  };

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center"> Add Job Card</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>Job Id :</label>
                    <input
                      placeholder="Job Id"
                      name="jobId"
                      className="form-control"
                      value={this.state.jobId}
                      onChange={this.changeJobIdHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label>Employee Id :</label>
                    <input
                      placeholder="Employee Id"
                      name="employeeId"
                      className="form-control"
                      value={this.state.employeeId}
                      onChange={this.changeEmployeeIdHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label>Customer Id :</label>
                    <input
                      placeholder="Customer Id"
                      name="customerId"
                      className="form-control"
                      value={this.state.customerId}
                      onChange={this.changeCusotmerIdHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label>Appointment Id :</label>
                    <input
                      placeholder="Appointment Id"
                      name="appointmentId"
                      className="form-control"
                      value={this.state.appointmentId}
                      onChange={this.changeAppointmentIdHandler}
                    />
                  </div>

                  <div className="form-group">
                    <label>VIN number :</label>
                    <input
                      placeholder="VIN number"
                      name="vechVin"
                      className="form-control"
                      value={this.state.vechVin}
                      onChange={this.changeVinNumberHandler}
                    />
                  </div>

                  <div className="form-group">
                    <input
                      type="checkbox"
                      id="service1"
                      name="service1"
                      checked={this.state.service1.checked}
                      value={"oil change"}
                      onChange={this.changeServices}
                    />
                    <label htmlFor="service1"> Oil change</label>
                    <input
                      type="checkbox"
                      id="service2"
                      name="service2"
                      checked={this.state.service2.checked}
                      value={"brake change"}
                      onChange={this.changeServices}
                    />
                    <label for="service2">Brake change</label>
                    <input
                      type="checkbox"
                      id="service3"
                      name="service3"
                      checked={this.state.service3.checked}
                      value={"full service"}
                      onChange={this.changeServices}
                    />
                    <label for="service3"> Full service</label>
                  </div>

                  <button className="btn btn-success" onClick={this.saveTask}>
                    {" "}
                    Save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    {" "}
                    Cancel
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateJobCardComponent;
