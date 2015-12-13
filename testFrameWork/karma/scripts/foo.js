(function (exports) {
    'use strict';

    function Cat(name) {
        this.name = name || 'Mike';
    }

    Cat.prototype.walk = function walk(direction) {
        if (!direction) {
            throw new Error('Put direction');
        }
        return this.name + ' walks to ' + direction;
    };

    exports.Cat = Cat;

}(this));
