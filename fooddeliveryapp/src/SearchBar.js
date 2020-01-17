import React, {Component} from 'react';
import Popup from './Popup'


class SearchBar extends Component {
  constructor(props){
    super(props);
    this.state={
      isPopupOpen:false,
      foods:[],
      foundFoods:[]
    };
  }

  async fetchData(){
    const foods = await fetch('http://localhost:9000/restaurant').catch((err)=>{
      console.log(err);
    })
    this.setState({foods: (await foods.json())})
  }
  componentDidMount(){
    this.fetchData();
  }
  searchFood(keyword){
    const { foods } = this.state;
    keyword = keyword.toLowerCase();
    const pattern = `[A-Za-z.\s]*${keyword}[A-Za-z.\s]*`;
    const matchRegex = new RegExp(pattern);
    const foundFoods = foods.filter((item)=> matchRegex.test(item.name.toLowerCase()))
    this.setState({ foundFoods})
  }
  onInputChange(e){
    const keyword = e.target.value;
    this.searchFood(keyword);
  }

  onInput(e){
    if (e.target.value!== "") this.showPopup();
    else this.hidePopup();
    //Show Popup
  }
  showPopup(){
    this.setState({ isPopupOpen:true})
  }
  hidePopup(){
    this.setState({isPopupOpen:false})

  }
  render() {
    const {isPopupOpen,foundFoods} = this.state;
    return (
      <div>
        <div className="content">
              <input 
                type="text" 
                placeholder="Search For Restaurant Items"
                onInput={this.onInput.bind(this)}
                onChange={this.onInputChange.bind(this)} />
              <Popup
                isOpen={isPopupOpen}
                items={foundFoods}
                />
        </div>
        
          
      </div>
    );
  }
}

export default SearchBar;
