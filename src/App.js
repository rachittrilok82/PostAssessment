import React from "react";
import './App.css';
class App extends React.Component {
   
    // Constructor 
    constructor(props) {
        super(props);
   
        this.state = {
            items: [],
            DataisLoaded: false,
            criteria:"",
            criteriaValue:""
        };
    }
  
  
      // ComponentDidMount is used to
    // execute the code 
    componentDidMount() {
      fetch(
"http://localhost:8080/skill-tracker/api/v1/engineer/admin/Skill/REACT")
          .then((res) => res.json())
          .then((json) => {
              this.setState({
                  items: [],
                  DataisLoaded: true,
                  criteria:"",
                  criteriaValue:""
              });
          })
  }


   
  
  //  handleSubmit = (event) => {
  //   event.preventDefault();
  //   alert(`The name you entered was`)
  // }
 
    render() {
        const { DataisLoaded, items } = this.state;
        if (!DataisLoaded) return <div>
            <h1> Pleses wait some time.... </h1> </div> ;
          
  const handleSubmit = (event) => {
    event.preventDefault();
    //alert(`The name you entered was:${this.state.criteria} `);
    this.setState({items:[]});
    console.log(this.state.criteria+"    "+this.state.criteriaValue);
    fetch(`http://localhost:8080/skill-tracker/api/v1/engineer/admin/${this.state.criteria}/${this.state.criteriaValue}`)
          .then((res) => res.json())
          .then((json) => {
              this.setState({
                  items: json,
                  DataisLoaded: true,
                
              });
          })

  }
        

   
        return (
        <div className = "App">
            <h1> Search Employee Based On Critera </h1> 
            <form onSubmit={handleSubmit}>
                  {/* <label>Choose Critera :
                  </label> */}
                    {/* <input 
                      type="text" 
                      name="CriteriaName"
                      value={this.state.criteria}
                      onChange={(e) => this.setState({criteria:e.target.value})}
                    /> */}
                      <div onChange={(e) => this.setState({criteria:e.target.value})}>
                      <span>Choose criteria :</span> <input type="radio" value="Name" name="crit" /> Name
                        <input type="radio" value="AssociateId" name="crit" /> Associate Id
                        <input type="radio" value="Skill" name="crit" />Skills 
                      </div>
                 
                  <label>Enter Criteria Value:    </label>
                    <input 
                      type="text" 
                      name="CriteriaValue"
                      value={this.state.criteriaValue}
                      onChange={(e) => this.setState({criteriaValue:e.target.value})}
                    />
           
                  <input type="submit" value="Search"/>
                </form>
            
             {

            


                items.map((item) => ( 
                // <ol >
                //     User_asid:{item.id},
                //     User_Name: { item.name }, 
                //     Full_Name: { item.mobile_no }, 
                //     User_Email: { item.email }

                //     {item.skillsList.map((it)=>(
                //        <ol>
                //          Skill_id:{it.skid}
                //          Skill_name:{it.skillname}
                //          Expertise_Level:{it.expertiselevel}
                //        </ol>
                       

                //     ))}
                    
                     
                //     </ol>

                
                              <table id="employee">
                                <tr>
                                  <th>Associate ID</th>
                                  <th>Name</th>
                                  <th>Mobile Number</th>
                                  <th>Email</th>
                                  <th>Created Date_Time</th>
                                  <th>Updated Date_Time</th>
                                  <th>Skills</th>
                                </tr>
                                <tr>
                                  <td>{item.id}</td>
                                  <td>{ item.name }</td>
                                  <td>{ item.mobile_no }</td>
                                  <td>{ item.email }</td>
                                  <td>{item.localDateTime}</td>
                                  <td>{item.updatedDateTime}</td>
                                  <td>
                                    <table class="empl">
                                      <tr>
                                      <th>Skills ID</th>
                                      <th>Skill Name</th>
                                      <th>Expertise Level</th>
                                      </tr>
                                      
                                      {item.skillsList.map((it)=>(
                       <tr>
                         <td>{it.skid}</td>
                         <td>{it.skillname}</td>
                         <td>{it.expertiselevel}</td>
                       </tr>
                       

                    ))}
                                      
                                    

                                    </table>

                                  </td>
                                </tr>
                                </table>
                ))
            }
               

        </div>
    );
    
}
}
   
export default App;