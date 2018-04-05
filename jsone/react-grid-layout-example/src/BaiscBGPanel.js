import React from 'react';

export default class BasicBGPanel extends React.Component {

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
                panelColor: '#00c5ff'
            });
        } else {
            this.setState({
                panelColor: '#eee'
            });
        }

    }

    render() {

        const divStyle = {
            width: 960,
            height: 800,
            backgroundColor: this.state.panelColor
        };

        return (
            <div
                style={divStyle}
            >

                <button onClick={this.handleClickChangeBGColorBtn}> 改变颜色</button>
            </div>
        );
    }


}
