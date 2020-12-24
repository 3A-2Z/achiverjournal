import {Component, useEffect,useState} from 'react'
import { Switch,Route,Link } from 'react-router-dom';
import {useHistory} from 'react-router-dom'
import './test.css';
import axios from 'axios'
import { wait, waitFor } from '@testing-library/react';
/*
* Functions as a view for the JournalEntry component
*/
function Entry(){
    
    let currPath = window.location.pathname.split("/#").join('').split('/')
    
    let entryID = " "
    entryID = (currPath.length === 3)? currPath[2] : currPath[1] // Parses the URL for an journal entry ID to be used in the fetching of any changes to that entry
    const history = useHistory()//tags on journal id to URL upon posting of new entry
    const [text,setText] = useState("")
    const [display,setDisplay] = useState(entryID === 'entry' ? true : false) // changes the mode of the journal entry for viewing or editing
    const [title,setTitle] = useState("")
    const [date,setDate] = useState("")
    const [tags,setTags] = useState("")
    const [ID,setID] = useState('')
    /*
    *   Sets all attributes from the retrived journal entry json that are to be displayed in the JournalEntry component view
    */
    function getEntryAttributes(entry){
        setText(prevState => entry.text)
        setTitle(prevState => entry.title)
        setDate(prevState => entry.date)
        setTags(prevState => entry.entryTags)

    }
   
    useEffect(
       () => fetch(`http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/${entryID}`).then(res => res.json()).then(entry => getEntryAttributes(entry)),[]
    )
    
    
    
    async function HandleClick(event){
        let jsonData = {"ID":"","title":title,"text":text} //Data to be sent to the JournalEntry API  to either insert into the dabase or update an existing journal
        
        event.preventDefault();
        
        if(entryID === 'entry' && display){ //Condition to insert a new journal entry (no entry ID provided within the URL)
            if(title.length === 0 || text.length === 0){
                alert("Please fill out the entry in full")//prevent submission of empty journal
                return
            }
            await axios({
                method: 'post',
                url: 'http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/api/v1/addentry', 
                data: {"ID":"","title":title,"text":text,}, 
                headers:{
                "Content-Type":'application/json',
                'Access-Control-Allow-Origin': '*',
                }}
            ).then(async res => res.data).then( async id => { 
                setID(prevState => id);entryID=id;console.log(id);              
           await fetch(`http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/${id}`).then(res => res.json()).then(entry => getEntryAttributes(entry));
            history.push(`/entry/${id}`);        
        })     
            .catch( err => console.log(err))
            
            
           
            
            
            

        }
        else if(display){//condition to update and existing journal
            if(title.length === 0 || text.length === 0){
                alert("Please fill out the entry in full")
                return
            }
            await axios.put(`http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/put/${entryID}`, 
              {"text":text,"title":title}
            ,{
                headers:{
                "Content-Type":"application/json",
                'Access-Control-Allow-Origin': '*',}}
            ).then( res => {console.log(res);
            fetch(`http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/${entryID}`).then(res => res.json()).then(entry => getEntryAttributes(entry));
            
            })
            .catch( err => console.log(err))
        }
        setDisplay(prevState => !prevState);


    }
   
    return (
       <form>
        {display?
        <div>
       <h1>
           <div class="question">
            <input
                class="question"
                type="text"
                value={title}
                onChange = {newTitle => {setTitle(prevState => newTitle.target.value);console.log(title)}} required/>
                <label>Entry Title</label>
            </div>
           
           
        </h1>
        <h3>Last Updated:{date}</h3>
        <div class="text">
            <textarea
            
            type="text"
            value={text}
            onChange={newText => {setText(prevState => newText.target.value);console.log(text);}}></textarea>
            </div>
        </div>
        :
        <div>
            <h1>{title}</h1>
            <h3>Last Updated:{date}</h3>
            <p >{text}</p>
       </div> 
        }
        <div>
            <span>
                <h1>What's on your mind!</h1>
                <br />
                <p>{tags}</p>
            </span>
        </div>
        <button onClick = {HandleClick}>Edit</button>
        <br />   
        <Link to="/journal"><button>Back to Entries</button></Link>
        </form>
        

    )



}
export default Entry