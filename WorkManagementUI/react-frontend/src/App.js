import logo from './logo.svg';
import './App.css';
import  {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

//import JobCardComponent from '../src/components/JobCardComponent'; -Test Component
import ListJobCardsComponent from '../src/components/ListJobCardsComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateJobCardComponent from './components/CreateJobCardComponent';

function App() {
  return (
    <div>
      <Router> 
        <div className = "container"> 
        <HeaderComponent/>
          <div className="container">
            <Switch> 
              <Route path = "/" exact component={ListJobCardsComponent}/>
              <Route path = "/jobcards" component={ListJobCardsComponent}/>
              <Route path = "/add-jobcard" component={CreateJobCardComponent}/>
                <ListJobCardsComponent/>
            </Switch>
          </div>
        <FooterComponent/>
        </div>
      </Router>
    </div>
    
  );
}

export default App;
