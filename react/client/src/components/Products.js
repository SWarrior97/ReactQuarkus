import React, { Component } from "react";
import '../css/main.css';
import '../css/util.css';


export class Products extends Component {
	handleClick = (e,sl) =>{
		e.preventDefault();
		
	} 

	  render() {
	  	
	  	return (
	  		<div className="limiter">
		        <div className="container-table100">
		          <div className="wrap-table100">
		            <div className="table100 ver1 m-b-110">
		              <div className="table100-head">
		                <table>
		                  <thead>
		                    <tr className="row100 head">
		                      <th className="cell100 column1">Name</th>
		                      <th className="cell100 column2">Price</th>
		                      <th className="cell100 column3">Quantity</th>
		                    </tr>
		                  </thead>
		                </table>
		              </div>
		              <div className="table100-body js-pscroll">
		                <table>
		                  <tbody>
		                    <tr className="row100 body">
		                      <td className="cell100 column1">{this.props.product.name}</td>
		                      <td className="cell100 column2">{this.props.product.price}</td>
		                      <td className="cell100 column3">{this.props.product.quantity}</td>
		                    </tr>
		                  </tbody>
		                </table>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
	  	);
	  }
}



export default Products;