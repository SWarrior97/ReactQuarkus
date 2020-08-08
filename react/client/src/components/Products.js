import React, { Component } from "react";
import '../css/main.css';
import '../css/util.css';
import Icon from '@material-ui/core/Icon';


export class Products extends Component {
	state = {
      view:1,
    };


	handleClick = (e) =>{
		e.preventDefault();
		this.setState({ view: 2 });
	} 

	  render() {
	  	switch(this.state.view){
	  		case 1:
	  		return (
		  		<div>
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
				                    
				                    {this.props.product.map((p) =>(
				                    	<tr className="row100 body">
					                    	<td className="cell100 column1">{p.name}</td>
					                    	<td className="cell100 column2">{p.price}</td>
					                    	<td className="cell100 column3">{p.quantity}</td>
				                    	</tr>
				                    ))}
				                    
				                  </tbody>
				                </table>
				              </div>
				            </div>
				          </div>
				        </div>
				      </div>

				      <div>
				      	<button className="button button5" onClick={e => this.handleClick(e)}>+</button>
				      </div>
		  		</div>
		  		
		  	);
	  		case 2:
	  		return (
	  			<h1>teste</h1>
	  		);
	  		default:
	  	}
	  	
	  }
}



export default Products;