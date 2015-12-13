/*global describe, it, expect, Cat*/
describe('Cat', function () {
    describe('initialize', function () {
        it('shold have a default name', function () {
            var cat = new Cat();
            expect(cat.name).toEqual('Mike');
        });

        it("should set cat's name if provided", function () {
            var cat = new Cat('Siro');
            expect(cat.name).toEqual('Siro');
        });
    });

    describe('walk method', function () {
        it('should walk passed target', function () {
            var greetings = (new Cat('Siro')).walk('North');
            expect(greetings).toEqual('Siro walks to North');
        });
    });
});
