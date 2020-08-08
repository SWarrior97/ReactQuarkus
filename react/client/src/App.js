import React from 'react';
import './App.css';
import './main.css';
import './util.css';
import backgroundImage from './bg-01.jpg';
import axios from 'axios';
import ShoopingList from './components/Shoppinglist';


class App extends React.Component {
  state = {
      email: '',
      password:'',
      view:1,
      isLogin:false,
      user:''
    };

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  onSubmit = (e) => {
    e.preventDefault();
    this.setState({ email: '' });
    this.setState({ password: '' });
    
    //axios.post
    //correct login change state
    console.log("teste");
    var bodyFormData = new FormData();
    bodyFormData.set('email', this.state.email);
    bodyFormData.set('password', this.state.password);
    var self = this;

    axios({
      method: 'post',
      url: 'http://localhost:8080/user/login',
      data: bodyFormData,
      headers: {'Content-Type': 'multipart/form-data' }
    })
    .then(function (response) {
        //handle success
        self.setState({ user:response.data[0] });
        self.setState({ view: 2 });

    })
    .catch(function (response) {
        //handle error
        console.log(response);
    });
  }

  render() {
    switch(this.state.view){
      case 1:
        return (
          <div className="limiter">
            <div className="container-login100">
              <div className="wrap-login100">
                <div className="login100-form-title">
                  <img src={backgroundImage} className="bg-image" alt="logo" />
                  <span className="login100-form-title-1">
                    Sign In
                  </span>
                </div>
                <form className="login100-form validate-form"  onSubmit={this.onSubmit} encType="multipart/form-data">
                  <div className="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                    <span className="label-input100">Username</span>
                    <input className="input100" type="email" name="email" placeholder="Enter email" value={this.state.email} onChange={this.onChange}/>
                    <span className="focus-input100" />
                  </div>
                  <div className="wrap-input100 validate-input m-b-18" data-validate="Password is required" value={this.state.password} onChange={this.onChange}>
                    <span className="label-input100">Password</span>
                    <input className="input100" type="password" name="password" placeholder="Enter password" />
                    <span className="focus-input100" />
                  </div>
                  
                  <div className="container-login100-form-btn">
                    <button className="login100-form-btn">
                      Login
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        );
      case 2:
        return this.state.user.shoppingLists.map((sl) => (
          <ShoopingList key={sl.id} sl = {sl}/>
         ));
      default:
      return (
        <h1>ERROR</h1>
      );
    }
  }
}

export default App;
