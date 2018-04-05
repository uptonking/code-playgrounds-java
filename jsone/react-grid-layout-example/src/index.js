import React from 'react';
import {render} from 'react-dom';
// import {GridLayout} from './GridLayout';
import BasicGridLayout from './BasicGridLayout';
import BasicBGPanel from './BaiscBGPanel';

const orderFormat = [
    {id: 1, order: 0, size: 1},
    {id: 2, order: 1, size: 1},
    {id: 3, order: 2, size: 2},
    {id: 4, order: 3, size: 1},
    {id: 5, order: 4, size: 1},
    {id: 6, order: 5, size: 2},
    {id: 7, order: 6, size: 2},
];


export default class App extends React.Component {

    constructor() {
        super();

        this.state = {
            panelColor: '#eee'
        }

        this.handleClickChangeBGColorBtn = this.handleClickChangeBGColorBtn.bind(this);

    }

    handleClickChangeBGColorBtn() {
        console.log('clicked');
        if (this.state.panelColor === '#eee') {
            this.setState({
                panelColor: 'rgba(0,215,255)'
            });
        } else {
            this.setState({
                panelColor: '#eee'
            });
        }

    }

    render() {

        const divStyle = {
            backgroundColor: this.state.panelColor
        };

        const defaultProps = {
            className: "layout",
            items: 20,
            rowHeight: 30,
            onLayoutChange: function () {
            },
            cols: 12
        };

        return (
            <div style={divStyle}>
                <button onClick={this.handleClickChangeBGColorBtn}> 改变颜色</button>

                {/*<BasicBGPanel>*/}
                {/*<GridLayout orderFormat={orderFormat}/>*/}
                <BasicGridLayout {...defaultProps} />
                {/*</BasicBGPanel>*/}
            </div>
        );
    }

}


render(<App/>, document.getElementById('root'));
