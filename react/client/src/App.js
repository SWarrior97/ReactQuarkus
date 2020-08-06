import React from 'react';
import logo from './logo.svg';
import './App.css';

class NameForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {name: '',password:''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    alert('A name was submitted: ' + this.state.name);
    event.preventDefault();
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        

          <form onSubmit={this.handleSubmit}>
            <label>
              Name:
              <input type="text" value={this.state.name} onChange={this.handleChange} />
            </label>

            <br/>

            <label>
              Password:
              <input type="text" value={this.state.password} onChange={this.handleChange} />
            </label>
            <br/>
            <input type="submit" value="Submit" />
        </form>
        </header>
      </div>
    );
  }
}

export default NameForm;
