import React from "react";
import RGL, {WidthProvider} from "react-grid-layout";

import 'react-grid-layout/css/styles.css';
import 'react-resizable/css/styles.css';

const ReactGridLayout = WidthProvider(RGL);

export default class BasicGridLayout extends React.PureComponent {

    constructor(props) {
        super(props);

        const layout = this.generateLayout();
        this.state = {layout};
    }

    generateDOM() {

        let panelArr = [];
        for (let i = 0; i < this.props.items; i++) {
            panelArr.push(
                <div
                    key={i}
                    style={{border: '0px solid', backgroundColor: 'rgb(0,215,255)'}}
                >
                    <span className="text">{i + 10}</span>
                </div>
            )
        }
        return panelArr;
    }

    generateLayout() {

        let layoutArr = [];
        for (let i = 0; i < this.props.items; i++) {
            const yy = this.props.y === undefined ? (Math.ceil(Math.random() * 4) + 1) : this.props.y;
            layoutArr.push(
                {
                    i: i.toString(),
                    // 不能写成 i%6
                    x: (i * 2) % 12,
                    y: Math.floor(i / 6) * yy,
                    w: 2,
                    h: yy
                }
            )
        }

        return layoutArr;

    }

    onLayoutChange(layout) {
        this.props.onLayoutChange(layout);
    }

    render() {

        return (
            <ReactGridLayout
                // className="layout"
                verticalCompact={true}
                // margin={[8,8]}
                // containerPadding={[19,19]}
                isResizable={true}
                layout={this.state.layout}
                onLayoutChange={this.onLayoutChange}
                {...this.props}
            >

                {this.generateDOM()}

            </ReactGridLayout>
        );

    }
}


