class Home < ActiveRecord::Base
  attr_accessible :id, :name
  validates :id, :length => { :maximum => 5 }
end
