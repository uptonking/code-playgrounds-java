import React from 'react';
import PropTypes from 'prop-types';
import ReactGridLayout from 'react-grid-layout';
import orderBy from 'lodash.orderby';

const HALF_WIDTH_SIZE = 1;
const FULL_WIDTH_SIZE = 2;

const colors = [
    '#FF0000',
    '#933e09',
    '#d95996',
    '#ba99b1',
    '#1c7ca5',
    '#f0a7ed',
    '#3205b2',
    '#deadbf',
];

function orderFormatToLayoutFormat(orderFormat) {
    let currentX = 0;
    let currentY = 0;

    return orderBy(orderFormat, 'order').map(order => {
        const layout = {
            i: String(order.id),
            x: currentX,
            y: currentY,
            w: order.size,
            h: 1,
        };

        const nextX = currentX + order.size;

        currentX = nextX < FULL_WIDTH_SIZE ? nextX : 0;
        currentY = nextX >= FULL_WIDTH_SIZE ? ++currentY : currentY;

        return layout;
    });
}

function layoutFormatToOrderFormat(layoutFormat) {
    return orderBy(layoutFormat, ['y', 'x']).map((layout, i) => ({
        id: Number(layout.i),
        order: i,
        size: layout.w,
    }));
}

export class GridLayout extends React.Component {

    static propTypes = {
        orderFormat: PropTypes.arrayOf(
            PropTypes.shape({
                id: PropTypes.number.isRequired,
                order: PropTypes.number.isRequired,
                size: PropTypes.oneOf([HALF_WIDTH_SIZE, FULL_WIDTH_SIZE]).isRequired,
            })
        ).isRequired,
    };

    state = {
        layout: orderFormatToLayoutFormat(this.props.orderFormat),
    };

    reflowLayout = layout => {
        console.table(layout, ['w', 'h', 'x', 'y']);
        const newLayout = orderFormatToLayoutFormat(
            layoutFormatToOrderFormat(layout)
        );
        this.setState({
            layout: newLayout,
        });
    };

    render() {

        return (
            <ReactGridLayout
                className="GridLayout"
                layout={this.state.layout}
                cols={2}
                compactType="horizontal"
                width={500}
                onDragStop={this.reflowLayout}>

                {this.state.layout.map(({i}) => (
                    <div
                        key={i}
                        style={{border: '1px solid', backgroundColor: colors[i]}}
                    />
                ))}

            </ReactGridLayout>
        );
    }


}
