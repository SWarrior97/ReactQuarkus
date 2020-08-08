import React, { Component } from "react";
import backgroundImage from '../bg-01.jpg';
import Product from './Products';


export class Shoppinglist extends Component {
	state = {
      view:1,
    };


	handleClick = (e,sl) =>{
		 e.preventDefault();
		 this.setState({ view: 2 });
	} 

	  render() {
	  	switch(this.state.view){
      		case 1:
			  	return (
			  		<div className="card" onClick={e => this.handleClick(e,this.props.sl)}>
		          		<br/>
		          		<br/>
		        		<img src={backgroundImage} alt="Avatar" style={{width: '100%'}} />
		          		<div className="container">
		        			<h4><b>{this.props.sl.name}</b></h4>
		          		</div>
		          		<br/>
		        	</div>

			  	);
			case 2:
				return this.props.sl.products.map((p) => (
		          <Product key={p.id} product = {p}/>
		         ));
			default:
				return(
					<h1>teste</h1>
				);
		}
	  }
}



export default Shoppinglist;